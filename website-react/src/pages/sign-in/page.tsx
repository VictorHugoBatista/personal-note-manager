import useSignInModel from "./sing-in.model";
import SignInView from "./sign-in.view";

const SignIn = () => {
  const model = useSignInModel();

  return <SignInView model={model} />;
};

export default SignIn;
