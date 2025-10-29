import { Link } from "react-router-dom";
import Panel from "../../layout/panel";

const HomeView = () => (
  <div className="-mx-3 h-full flex">
    <Panel extraStyles="flex-col flex-1 justify-evenly items-center w-full">
      <p className="text-xl font-bold">Create your own notes in markdown format!</p>

      <div>
        <Link className="inline-block m-2 py-3 px-4 rounded-sm bg-blue-500 text-white text-xl shadow-md shadow-blue-300 transition duration-200 ease-in-out hover:bg-blue-200 hover:shadow-xl hover:scale-110" to={'/sign-in'}>Sign in</Link>
        <Link className="inline-block m-2 py-3 px-4 rounded-sm bg-blue-500 text-white text-xl shadow-md shadow-blue-300 transition duration-200 ease-in-out hover:bg-blue-200 hover:shadow-xl hover:scale-110" to={'/sign-up'}>Sign up</Link>
      </div>
    </Panel>
  </div>
);

export default HomeView;
