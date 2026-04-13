module modulo_6_counter_tb();
    reg clk, clr;
    wire [2:0] counter;
    integer i;

    modulo_6_counter mod_6 (.clk(clk), .clr(clr), .counter(counter));

    initial begin
        $dumpfile("modulo_6_counter.vcd");
        $dumpvars(0, modulo_6_counter_tb);

        clk = 0;
        clr = 1;

        #5
        $display("0 : counter = 3'b%b", counter);
        clr = 0;

        for (i = 1; i < 15; i = i + 1) begin
            #10 $display("%d : counter = 3'b%b", i, counter);
        end

        $finish;
    end

    always begin
        #5 clk = ~clk;
    end
endmodule