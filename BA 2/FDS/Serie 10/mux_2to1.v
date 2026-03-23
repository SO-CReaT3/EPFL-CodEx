module mux_2to1 (
    input x1,
    input x2,
    input s,

    output reg f
);
    always @* begin
        if (s == 1)
        begin
            f = x2;
        end
        else
        begin
            f = x1;
        end
    end
endmodule