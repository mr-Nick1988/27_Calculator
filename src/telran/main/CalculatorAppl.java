package telran.main;


import telran.dao.Operation;
import telran.dao.impl.Add;
import telran.dao.impl.Subtract;

import java.util.HashMap;
import java.util.Map;

public class CalculatorAppl {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        //here you can add your method
        registerOperation(new Add());
        registerOperation(new Subtract());
    }

    public static void registerOperation(Operation operation) {
        operations.put(operation.getName().toLowerCase(), operation);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: number1 , number2 , operation");
            return;
        }
        try {
            double number1 = Double.parseDouble(args[0]);
            double number2 = Double.parseDouble(args[1]);
            String operationName = args[2].toLowerCase();
            Operation operation = operations.get(operationName);

            if (operation == null) {
                System.out.println("Operation unknown: " + args[2]);
                return;
            }
            double res = operation.execute(number1, number2);
            System.out.println("Result: " + res);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }catch (Exception e ){
            System.out.println("Error: " +e.getMessage());
        }
    }


}
