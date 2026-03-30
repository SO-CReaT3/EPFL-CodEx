module counter_12_bits (
    input clk,
    output reg [11:0] Q
);
    integer i;

    // Clear value
    reg [11:0] max_value = 12'b111111111111;

    initial begin
        Q = 12'b0;
    end

    always @ (posedge clk) begin
        if (Q == max_value) Q = 12'b0;
        else Q = Q + 'b1;
    end
endmodule