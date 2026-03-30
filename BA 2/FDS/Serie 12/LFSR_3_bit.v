module LFSR_3_bit (
    input clk,
    input [2:0] seed,

    output reg [2:0] Q
);

    always @ (posedge clk, seed) begin
        if (Q === 3'bxxx) Q = seed;
        else Q = {Q[1], Q[2] ^ Q[0], Q[2]};
    end
endmodule