import { ReactNode } from "react";

interface Props {
  children: ReactNode,
  labelText?: string,
  labelId?: string,
}

const FormRow = ({ children, labelText, labelId }: Props) => (
  <div className="mb-4 flex flex-col">
    {labelText ? <label htmlFor={labelId} className="mb-1 mr-3 flex">{labelText}</label> : null}
    {children}
  </div>
);

export default FormRow;
