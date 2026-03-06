package com.smartexpense.controller;

import com.smartexpense.dto.ExpenseDto;
import com.smartexpense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto dto, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(expenseService.createExpense(dto, userDetails.getUsername()));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> listExpenses(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(expenseService.listExpenses(userDetails.getUsername()));
    }
}
