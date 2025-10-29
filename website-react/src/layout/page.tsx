import { ReactNode } from "react";

import Footer from "./footer";
import Header from "./header";

interface Props {
  children: ReactNode;
}

const Page = ({ children }: Props) => (
  <div className="flex flex-col bg-amber-50 h-full justify-between">
    <Header />

    <div className="container mx-auto flex flex-1 flex-col">
      {children}
    </div>

    <Footer />
  </div>
);

export default Page;
