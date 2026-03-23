module bin_decoder_3to8_tb;

  // Define three inputs that can procedurally be assigned values.
  reg  [2:0] in;
  // And one output that responds to them.
  wire [7:0] out;

  // Connect them to an instantiated mux_2to1 module.
  bin_decoder_3to8 bin_decoder (.in(in), .out(out));

  integer i;

  initial begin
    // Write this test's data to a .vcd file that GTKWave can read.
    $dumpfile ("bin_decoder_3to8.vcd");
    $dumpvars;

    // Print values whenever they change.
    $monitor ("Time %2t, in=%b, out=%b",
              $time, in, out);

    // Exhaust all input combinations,
    // each time followed by a delay of 1 time unit.
    for (i = 0; i < 8; i = i + 1) begin
        in = i; #1;
    end

    // Done.
    $finish;
  end

endmodule
