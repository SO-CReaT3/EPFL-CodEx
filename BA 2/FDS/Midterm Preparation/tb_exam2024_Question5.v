module tb_exam2024_Question5();
    reg a, b, c, w, z;
    wire f;
    integer i = 0;

    global_circuit peepee (.a(a), .b(b), .c(c), .w(w), .z(z), .f(f));

    initial begin
        $dumpfile("exam2024_Question5.vcd");
        $dumpvars;

        a = 1;
        b = 0;
        c = 0;
        w = 1;
        z = 1;
        #20;

        $display("a: %d, b: %d, c: %d, w: %d, z: %d, f: %d", a, b, c, w, z, f);

        $finish;
    end
endmodule