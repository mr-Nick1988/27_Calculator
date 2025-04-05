package telran.main;

public class CalculatorAppl {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: number1 , number2 , operation");
            return;
        }

        try {
            double number1 = Double.parseDouble(args[0]);
            double number2 = Double.parseDouble(args[1]);
            String operation = args[2];


          String operationClassName = operation.substring(0, 1).toUpperCase()
                    + operation.substring(1).toLowerCase();

            String fullClassName = "telran.dao.impl." + operationClassName;
            Class<?> operationClass = Class.forName(fullClassName);
            Object instance = operationClass.getDeclaredConstructor().newInstance();
            telran.dao.Operation operationInstance = (telran.dao.Operation) instance;
            double res = operationInstance.execute(number1, number2);
            System.out.println("Result: " + res);


        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        } catch (ClassNotFoundException e) {
            System.out.println("Operation unknown: " + args[2]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}