package com.michael;

public class Component {

    private final String component_type;
    private final String condition;

    public Component(String type, String cond) {
        component_type = type;
        condition = cond;
    }

    public String generate_assembly() {

        String start_label = "if_start_0";
        String end_label = "if_end_0";
        String register = "0";
        String branch_label = "subroutine_name";
        String operand2 = "#3";

        String generated_assembly = "";

        generated_assembly += """
                    {0}:
                    \tCMP R{1}, {2}
                    """; // START LABEL

        switch (condition) {
            case "=":
                generated_assembly += "\tBEQ {3}";
                break;
            case "<":
                generated_assembly += "\tBLT {3}";
                break;
            case ">":
                generated_assembly += "\tBGT {3}";
                break;
            case "<=":
                generated_assembly += "\tBLT {3}";
                generated_assembly += "\n\tBEQ {3}";
                break;
            case ">=":
                generated_assembly += "\tBGT {3}";
                generated_assembly += "\n\tBEQ {3}";
                break;
            case "!=":
                generated_assembly += "\tBLT {3}";
                generated_assembly += "\n\tBGT {3}";
                break;
        }

        generated_assembly += "\n{4}:\n\tHALT:";

        generated_assembly = generated_assembly.replace("{0}", start_label);
        generated_assembly = generated_assembly.replace("{1}", register);
        generated_assembly = generated_assembly.replace("{2}", operand2);
        generated_assembly = generated_assembly.replace("{3}", branch_label);
        generated_assembly = generated_assembly.replace("{4}", end_label);

        return generated_assembly;
    }

}
