import { ReactNode } from "react";

interface Props {
  children: ReactNode;
  extraStyles?: string;
}

const Panel = ({ children, extraStyles = '' }: Props) => (
  <div className={`flex justify-left m-3 p-5 shadow-xl rounded-md bg-white/75 ${extraStyles}`}>
    {children}
  </div>
);

export default Panel;
