import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetailerProductComponent } from './retailer-product.component';

describe('RetailerProductComponent', () => {
  let component: RetailerProductComponent;
  let fixture: ComponentFixture<RetailerProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RetailerProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RetailerProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
