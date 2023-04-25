import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ElectronicsService } from '../../service/electronics.service';
import { NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  url: String = '';
  userName: String = '';

  constructor(
    private gService: ElectronicsService,
    private router: Router,
    private changeDetector: ChangeDetectorRef
  ) {
    if (this.gService.getAdminName() !== null) {
      this.userName = this.gService.getAdminName();
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
    if (link === '/admin/logout') {
      this.gService.clientLogout();
      return;
    }
    this.router.navigate([link]);
  }
}
