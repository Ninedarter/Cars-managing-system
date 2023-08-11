package com.example.Car_Service.response;

import com.example.Car_Service.model.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {

    private List<Expense> expenses;

}
