class Complex {
    double re, im; // 3 + 2 i

    double abs() {
        return Math.sqrt(re*re + im*im);
    }

    void add(Complex that) { // 4 + 2 i
        re += that.re;
        im += that.im;
    }

    void sub(Complex that) {
        re -= that.re;
        im -= that.im;
    }

    void mul(Complex that) {
        double new_re = this.re*that.re - this.im*that.im;
        double new_im = this.re*that.im + this.im*that.im;
        re = new_re;
        im = new_im;
    }
}