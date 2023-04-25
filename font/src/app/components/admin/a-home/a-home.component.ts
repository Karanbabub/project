import { Component, OnInit } from '@angular/core';
import { ElectronicsService } from '../../service/electronics.service';

@Component({
  selector: 'app-a-home',
  templateUrl: './a-home.component.html',
  styleUrls: ['./a-home.component.scss']
})
export class AHomeComponent implements OnInit {
  userName: void;
  constructor(
    private gService: ElectronicsService
  ) {
    if (this.gService.getAdminName() !== null) {
      this.userName = this.gService.getAdminName();
    }
    this.gService.isAdminLoginPresent();
  }

  ngOnInit(): void {
  }

}
