import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss'],
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[];

  constructor() {}

  ngOnInit(): void {
    this.employees = [
      {
        id: 1,
        firstName: 'Marcos',
        lastName: 'Castro',
        emailId: 'mpcc.show@gmail.com',
      },
      {
        id: 2,
        firstName: 'Nilmara',
        lastName: 'Cunha',
        emailId: 'nilmara.cunha@gmail.com',
      },
    ];
  }
}
