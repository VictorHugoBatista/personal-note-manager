import { Link } from "react-router-dom";
import Panel from "./panel";
import PageRoute from "../pages/page-route";

const Header = () => (
  <Panel>
    <div className="container mx-auto">
      <h1 className="text-3xl"><Link to={PageRoute.HOME}>Personal Note Manager</Link></h1>
    </div>
  </Panel>
);

export default Header;
