import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortbypriceLowtohighComponent } from './sortbyprice-lowtohigh.component';

describe('SortbypriceLowtohighComponent', () => {
  let component: SortbypriceLowtohighComponent;
  let fixture: ComponentFixture<SortbypriceLowtohighComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortbypriceLowtohighComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortbypriceLowtohighComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
