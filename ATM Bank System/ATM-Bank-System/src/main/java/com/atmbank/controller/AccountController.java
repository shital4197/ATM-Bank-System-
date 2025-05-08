//package com.atmbank.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    private final AccountService service;
//
//    public AccountController(AccountService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<Account> register(@RequestBody Account account) {
//        return ResponseEntity.ok(service.createAccount(account));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Account> login(@RequestBody Map<String, String> req) {
//        Long id = Long.parseLong(req.get("id"));
//        String pin = req.get("pin");
//        return service.authenticate(id, pin)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.status(401).build());
//    }
//
//    @PostMapping("/{id}/deposit")
//    public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestBody Map<String, Double> req) {
//        return service.deposit(id, req.get("amount"))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    @PostMapping("/{id}/withdraw")
//    public ResponseEntity<Account> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> req) {
//        Account account = service.withdraw(id, req.get("amount")).orElse(null);
//        if (account == null) return ResponseEntity.badRequest().build();
//        return ResponseEntity.ok(account);
//    }
//
//    @GetMapping("/{id}/balance")
//    public ResponseEntity<Double> checkBalance(@PathVariable Long id) {
//        return service.checkBalance(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/{id}/transactions")
//    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getTransactionHistory(id));
//    }
//}
