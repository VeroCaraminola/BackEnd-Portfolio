import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logo-ar-pr',
  templateUrl: './logo-ar-pr.component.html',
  styleUrls: ['./logo-ar-pr.component.css']
})
export class LogoAPComponent implements OnInit {
 constructor(private router: Router) {}
  ngOnInit(): void {
    
  }

  login(){  
    this.router.navigate(['/login'])
}

}