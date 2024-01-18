import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WomenClothesComponent } from './women-clothes.component';

describe('WomenClothesComponent', () => {
  let component: WomenClothesComponent;
  let fixture: ComponentFixture<WomenClothesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WomenClothesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WomenClothesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
