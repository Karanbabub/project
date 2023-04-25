import { Component, OnInit } from '@angular/core';
import { ElectronicsService } from '../../service/electronics.service';
import { NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-c-header',
  templateUrl: './c-header.component.html',
  styleUrls: ['./c-header.component.scss'],
})
export class CHeaderComponent implements OnInit {
  url: string = '/client/home';
  userName: string = '';
  constructor(private gService: ElectronicsService, private router: Router) {
    if (this.gService.getClientName() !== null) {
      this.userName = this.gService.getClientName();
    }
  }

  ngOnInit(): void {
    this.router.events
      .pipe(filter((event) => event instanceof NavigationStart))
      .subscribe((event: any) => {
        this.url = event?.url;
      });
  }
  routerToLink(link: string): void {
    if (link === '/client/logout') {
      this.gService.clientLogout();
      return;
    }
    this.router.navigate([link]);
  }
}
