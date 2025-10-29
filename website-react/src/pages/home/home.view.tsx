import Panel from "../../layout/panel";
import PageRoute from "../page-route";
import Button from "../../components/forms/button";

const HomeView = () => (
  <div className="-mx-3 h-full flex">
    <Panel extraStyles="flex-col flex-1 justify-evenly items-center w-full">
      <p className="text-xl font-bold">Create your own notes in markdown format!</p>

      <div>
        <Button link={PageRoute.SIGN_IN}>
          Sign in
        </Button>
        <Button link={PageRoute.SIGN_UP}>
          Sign up
        </Button>
      </div>
    </Panel>
  </div>
);

export default HomeView;
