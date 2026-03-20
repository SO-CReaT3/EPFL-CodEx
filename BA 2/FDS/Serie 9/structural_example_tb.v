module test_structural_example;
// Define three inputs that can procedurally
// be assigned values.

// For ex1
reg a1, b1, c1;
// And one output that responds to them.
wire f1;

// For ex2
reg a2, b2, c2;
// And one output that responds to them.
wire f2;

// Connect them to an instance of the module being tested.
structural_example ex1 (.a(a1), .b(b1), .c(c1), .f(f1));
exercice_2_b ex2 (.a(a2), .b(b2), .c(c2), .f(f2));

// Loop variable.
integer i;

initial begin
    // Write this test's data to a .vcd file
    // that GTKWave can read.
    $dumpfile ("structural_example.vcd");
    $dumpvars;
    // Print values whenever they change.
    $monitor ("ex1 : Time %2t, a1=%b, b1=%b, c1=%b, f1=%b; ex2 : Time %2t, a2=%b, b2=%b, c2=%b, f2=%b",
    $time, a1, b1, c1, f1, a2, b2, c2, f2);

    // Exhaust all input combinations,
    // each time followed by a delay of 1 time unit.
    for (i = 0; i < 8; i = i + 1) begin
        // Each variable gets one bit from i.
        // First 0, 0, 0
        // then 0, 0, 1, etc.
        {a1, b1, c1} = i;
        {a2, b2, c2} = i;
        #1;
    end
    // Done.
    $finish;
end
endmodule