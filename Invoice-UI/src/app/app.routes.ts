import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { JupiterComponent } from './jupiter/jupiter.component';
import { PayrollInvoiceComponentComponent } from './payroll-invoice-component/payroll-invoice-component.component';
import { ExpensesTypeManagementComponent } from './expenses-type-management/expenses-type-management.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UtilityExpensesComponent } from './utility-expenses/utility-expenses.component';
import { ClientManagementComponent } from './Client-Management/client-management.component';
import { ClientInvoiceManagementComponent } from './client-invoice-management/client-invoice-management.component'; // Import the component

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent }, // canActivate: [authGuard] },
    { path: 'payroll', component: PayrollInvoiceComponentComponent }, // canActivate: [authGuard] },
    { path: 'utility', component: UtilityExpensesComponent }, // canActivate: [authGuard] },
    { path: 'jupiter', component: JupiterComponent },
    { path: 'navbar', component: NavbarComponent },
    { path: 'Expensetype', component: ExpensesTypeManagementComponent },
    { path: 'clients', component: ClientManagementComponent },
    { path: 'client-invoice', component: ClientInvoiceManagementComponent } // Added route for Client Invoice Management
];
