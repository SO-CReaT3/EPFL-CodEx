module test_exercice_2_c;
// Define three inputs that can procedurally
// be assigned values.

// full_adder1
reg x1, y1, Cin1;
// And two output that responds to them.
wire s1, Cout1;

// For ex2
reg x2, y2, Cin2;
// And two output that responds to them.
wire s2, Cout2;

// Connect them to an instance of the module being tested.
full_adder1 FA1 (.x(x1), .y(y1), .s(s1), .Cin(Cin1), .Cout(Cout1));
full_adder2 FA2 (.x(x2), .y(y2), .s(s2), .Cin(Cin2), .Cout(Cout2));

// Loop variable.
integer i;

initial begin
    // Write this test's data to a .vcd file
    // that GTKWave can read.
    $dumpfile ("exercice_2_c.vcd");
    $dumpvars;
    // Print values whenever they change.
    $monitor ("FA1 : Time %2t, x1=%b, y1=%b, Cin1=%b, s1=%b, Cout1=%b; FA2 : Time %2t, x2=%b, y2=%b, Cin2=%b, s2=%b, Cout2=%b",
    $time, x1, y1, Cin1, s1, Cout1, $time, x2, y2, Cin2, s2, Cout2);

    // Exhaust all input combinations,
    // each time followed by a delay of 1 time unit.
    for (i = 0; i < 8; i = i + 1) begin
        // Each variable gets one bit from i.
        // First 0, 0, 0
        // then 0, 0, 1, etc.
        {x1, y1, Cin1} = i;
        {x2, y2, Cin2} = i;
        #1;
    end
    // Done.
    $finish;
end
endmodule