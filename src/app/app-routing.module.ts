import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { LoginGuard } from './login.guard';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PizzaComponent } from './pizza/pizza.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
{path:"register",component:RegisterComponent},
{path:"login",component:LoginComponent},
{path:"pizza",component:PizzaComponent,canActivate:[LoginGuard]},
// {path:"**",redirectTo:"register"} //
];  //,

@NgModule({ //takes metadata object 
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
}) //htco and htcrIn
export class AppRoutingModule { }
