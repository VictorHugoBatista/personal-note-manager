import { ReactNode } from "react";
import { Link } from "react-router-dom";
import PageRoute from "../../pages/page-route";

interface Props {
  children: ReactNode,
  link: PageRoute,
}

const Button = ({ children, link }: Props) => (
  <Link className="inline-block m-2 py-3 px-4 rounded-sm bg-blue-500 text-white text-xl shadow-md shadow-blue-300 transition duration-200 ease-in-out hover:bg-blue-200 hover:shadow-xl hover:scale-110" to={link}>
    {children}
  </Link>
);

export default Button;
