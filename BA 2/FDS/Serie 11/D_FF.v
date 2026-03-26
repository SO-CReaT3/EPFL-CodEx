module D_FF (
    input clk,
    input reset,
    input set,
    input D,

    output reg Q,
    output reg Q_n
);
    always @ (posedge clk, Q)
    begin
        if (reset == 1) Q <= 0;
        else if (set == 1) Q <= 1;
        else Q <= D;

        Q_n <= ~Q;
    end
endmodule