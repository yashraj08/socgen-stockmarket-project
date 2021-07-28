export interface User {
    username: string,
    password: string,
    email: string,
    mobile: string;
    isdCode: string;
    isAdmin?:boolean;
    confirmed?:boolean;
  }