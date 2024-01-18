import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerProductsearchComponent } from './customer-productsearch.component';

describe('CustomerProductsearchComponent', () => {
  let component: CustomerProductsearchComponent;
  let fixture: ComponentFixture<CustomerProductsearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerProductsearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerProductsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
