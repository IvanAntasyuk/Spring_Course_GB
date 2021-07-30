import { Injectable } from '@angular/core';
import {Product} from "./product";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // private identity: number =6;
  //
  // private products:{[key:number]: Product}={
  //   1: new Product(1,'Milk',60),
  //   2: new Product(2,'Bread',30),
  //   3: new Product(3,'Soda',10),
  //   4: new Product(4,'Orange',50),
  //   5: new Product(5,'Fish',90),
  // }



  constructor(public http: HttpClient) { }
public findAll(){
    return this.http.get<Product[]>('api/v1/product/all').toPromise();
//     return new Promise<Product[]>((resolve, reject)=>
//     {
//       resolve(Object.values(this.products))
//     })
 }
  public findById(id: number) {
    return this.http.get<Product>(`/api/v1/product/${id}`).toPromise();
    // return new Promise<Product>((resolve, reject) =>
    // {
    //   resolve(
    //     this.products[id]
    //   )
    // })
  }
  public save(product: Product) {
    return this.http.put("/api/v1/product/",product).toPromise();
    // return new Promise<void>((resolve, reject) => {
    //   if (user.id == -1) {
    //     user.id = this.identity++;
    //   }
    //   this.products[user.id] = user;
    //   resolve();
    // })
  }

  public delete(id: number) {
    return this.http.delete(`/api/v1/product/${id}`).toPromise();
  }
  //   return new Promise<void>((resolve, reject) => {
  //     delete this.products[id];
  //     resolve();
  //   })
  // }


}
