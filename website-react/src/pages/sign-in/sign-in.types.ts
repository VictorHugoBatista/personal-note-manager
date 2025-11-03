import { FieldErrors, SubmitHandler, UseFormHandleSubmit, UseFormRegister } from "react-hook-form";

export type Login = {
  email: string;
  password: string;
}

export type SignInModel = {
  form: SignInForm;
};

export type SignInForm = {
  register: UseFormRegister<Login>,
  handleSubmit: UseFormHandleSubmit<Login, Login>,
  errors: FieldErrors,
  onSubmit: SubmitHandler<Login>,
};
