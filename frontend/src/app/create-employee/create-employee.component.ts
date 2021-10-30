import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.scss'],
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  saveEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe((data) => {
      console.log(data);
      this.toEmployeeList();
    });
    (error) => console.error(error);
  }

  toEmployeeList(): void {
    this.router.navigate(['/employees']);
  }

  onSubmit(): void {
    this.saveEmployee();
  }
}
