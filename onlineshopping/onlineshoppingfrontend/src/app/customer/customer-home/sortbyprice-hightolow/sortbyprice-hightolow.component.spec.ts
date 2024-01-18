import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortbypriceHightolowComponent } from './sortbyprice-hightolow.component';

describe('SortbypriceHightolowComponent', () => {
  let component: SortbypriceHightolowComponent;
  let fixture: ComponentFixture<SortbypriceHightolowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortbypriceHightolowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortbypriceHightolowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
