import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenClothesComponent } from './men-clothes.component';

describe('MenClothesComponent', () => {
  let component: MenClothesComponent;
  let fixture: ComponentFixture<MenClothesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenClothesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenClothesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
