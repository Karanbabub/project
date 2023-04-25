import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [NgbCarouselConfig],
})
export class HomeComponent implements OnInit {
  logo: string = '.jpg';
  images = [
    '../../../assets/images/About.png',
    '../../../assets/images/Banner2.jpeg',
    '../../../assets/images/ps.jpeg',
  ];

  constructor(config: NgbCarouselConfig, private route: Router) {
    config.interval = 500;
    config.keyboard = false;
    config.pauseOnHover = false;
  }

  ngOnInit(): void {}

  gotoLogin(): void {
    this.route.navigate(['/client-login']);
  }
}
