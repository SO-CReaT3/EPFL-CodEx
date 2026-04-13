module modulo_6_counter(
    input clk, // enable input
    input clr, // reset input

    output reg [2:0] counter
);
    always @ (posedge clk, clr)
        if (clr || counter == 5) counter <= 3'b000;
        else counter = counter + 1;
endmodule