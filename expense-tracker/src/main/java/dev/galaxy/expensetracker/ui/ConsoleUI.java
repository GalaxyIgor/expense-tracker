package dev.galaxy.expensetracker.ui;
import dev.galaxy.expensetracker.service.ExpenseService;

import java.util.Scanner;

public class ConsoleUI {
    private ExpenseService service;
    private Scanner scanner;

    public ConsoleUI(ExpenseService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        System.out.println("=== BEM-VINDO AO EXPENSE TRACKER ===");

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> listExpenses();
                case 3 -> showTotal();
                case 4 -> {
                    running = false;
                    System.out.println("Encerrando...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Adicionar | 2. Listar | 3. Total | 4. Sair");
        System.out.print("Escolha: ");
    }

    private void addExpense() {
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        System.out.print("Valor: ");
        double val = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Categoria: ");
        String cat = scanner.nextLine();
        service.addExpense(desc, val, cat);
    }

    private void listExpenses() {
        System.out.println("\n--- Lista de Despesas ---");
        service.getAllExpenses().forEach(System.out::println);
    }

    private void showTotal() {
        System.out.printf("Total acumulado: R$ %.2f\n", service.calculateTotal());
    }
}