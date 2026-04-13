module tbExcess3 ();
    reg clk;
    reg reset;
    reg load;
    reg [3:0] parallel_in;
    reg read;
    reg enable;
    wire [3:0] parallel_out;

    reg [3:0] expunits;
    reg [3:0] exptens;

    integer i;

    TwoDigitCnt dut (
        .DIN(parallel_in),
        .READ(read),
        .clk(clk),
        .EN(enable),
        .INIT(reset),
        .LOAD(load),
        .DOUT(parallel_out)
    );
    
    initial begin
        $dumpfile("dump.vcd");
        $dumpvars(0, tbExcess3);
        
        clk = 0;
        reset = 1;
        load = 0;
        read = 0;
        enable = 1;
        parallel_in = 4'b0000;
        #10;
        reset = 0;
        for (i = 1; i < 250; i = i + 1) begin
            #8;
            expunits = ((i)%10) + 3;
            exptens = (((i)/10)%10) + 3;
            read = 0;
            #1;
            if (parallel_out != expunits) begin
                $display("Error units: parallel_out = %d, expected = %d, at time = %d",
                            parallel_out, expunits, i);
                $finish;
            end
            read = 1;
            #1;
            if (parallel_out != exptens) begin
                $display("Error tens: parallel_out = %d, expected = %d, at time = %d",
                            parallel_out, exptens, i);
                $finish;
            end
        end
        $display("Pass reset");
        // check parallel load
        reset = 0;
        load = 1;
        parallel_in = 4'b0010;
        #10;
        load = 0;
        for (i = 1; i < 250; i = i + 1) begin
            #8;
            expunits = ((i+22)%10) + 3;
            exptens = (((i+22)/10)%10) + 3;
            read = 0;
            #1;
            if (parallel_out != expunits) begin
                $display("Error units: parallel_out = %d, expected = %d, at time = %d",
                            parallel_out, expunits, i);
                $finish;
            end
            read = 1;
            #1;
            if (parallel_out != exptens) begin
                $display("Error tens: parallel_out = %d, expected = %d, at time = %d",
                            parallel_out, exptens, i);
                $finish;
            end
        end
        $display("Pass parallel load");

        $finish;
    end

    always begin
        #5 clk = ~clk;
    end
endmodule