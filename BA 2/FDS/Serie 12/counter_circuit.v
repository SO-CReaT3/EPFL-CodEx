module counter_circuit (
    input clk,
    input clr,
    output reg [3:0] X,
    output reg [3:0] Y
);

    wire enable_x = 1;
    wire enable_y;

    reg [3:0] D = 'b0000;

    wire load_x;
    wire load_y;

    assign enable_y = X[0] & X[3];
    assign load_x = clr | enable_y;
    assign load_y = clr | (enable_y & Y[0] & Y[3]);

    always @ (posedge clk) begin
        // First counter
        if (load_x) X = D;
        else if (enable_x) X = X + 1'b1;

        // Second counter
        if (load_y) Y = D;
        else if (enable_y) Y = Y + 1'b1;
    end
endmodule