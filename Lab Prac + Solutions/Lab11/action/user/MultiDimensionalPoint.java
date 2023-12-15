package action.user;

import java.util.Arrays;
import java.util.Objects;

import action.Scalable;
import action.Undoable;

public class MultiDimensionalPoint implements Scalable, Undoable, Comparable<MultiDimensionalPoint> {
    private int[] coordinates;
    private int[] lastCoordinates;

    public MultiDimensionalPoint(int... coordinates) {
        this.coordinates = new int[coordinates.length];
        System.arraycopy(coordinates, 0, this.coordinates, 0, coordinates.length);

        this.lastCoordinates = new int[coordinates.length];
        System.arraycopy(coordinates, 0, this.lastCoordinates, 0, coordinates.length);
    }

    public int get(int idx) {
        return coordinates[idx];
    }

    public void set(int idx, int value) {
        saveToLast();
        coordinates[idx] = value;
    }

    @Override
    public void scale(int factor) {
        saveToLast();

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] *= factor;
        }
    }

    private void saveToLast() {
        this.lastCoordinates = new int[coordinates.length];
        System.arraycopy(coordinates, 0, this.lastCoordinates, 0, coordinates.length);
    }

    @Override
    public void undoLast() {
        int[] tmp = lastCoordinates;
        lastCoordinates = coordinates;
        coordinates = tmp;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)   return true;
        if (other instanceof MultiDimensionalPoint mdp) {
            return Arrays.equals(this.coordinates, mdp.coordinates);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (coordinates.length > 0)  sb.append(coordinates[0]);
        for (int i = 1; i < coordinates.length; i++) {
            sb.append(coordinates[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public int compareTo(MultiDimensionalPoint mdp) {
        int dimDiff = coordinates.length - mdp.coordinates.length;
        if (dimDiff != 0)   return dimDiff;

        for (int i = 0; i < coordinates.length; i++) {
            int coordDiff = coordinates[i] - mdp.coordinates[i];
            if (coordDiff != 0)   return coordDiff;
        }
        
        return 0;
    }
}
