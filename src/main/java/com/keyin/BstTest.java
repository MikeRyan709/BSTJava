package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class BstTest {
    public static void main(String[] args) {
        SpringApplication.run(BstTest.class, args);
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        int[] input = new int[n];

        System.out.println("Enter the values: ");
        for (int i = 0; i < n; i++) {
            int newInput = sc.nextInt();
            bst.insert(newInput);
            input[i] = newInput;
        }

        System.out.println("traversal of BST: ");
        bst.preOrder(BST.root);
        System.out.println("\n Root: ");
        System.out.println(BST.root.value);
        sc.close();
    }
}

