import { SubmitHandler, useForm } from "react-hook-form";

import { Login, SignInModel } from "./sign-in.types";
import { LoginSchema } from "./sign-in.schema";

const useSignInModel = (): SignInModel => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Login>();

  const onSubmit: SubmitHandler<Login> = (dataForm: Login) => {
    const dataParsed = LoginSchema.safeParse(dataForm);

    if (! dataParsed.success) {
      return;
    }

    console.log('login on api');
  };

  return {
    form: {
      register,
      handleSubmit,
      errors,
      onSubmit,
    },
  }
};

export default useSignInModel;

