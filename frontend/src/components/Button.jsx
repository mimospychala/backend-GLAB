import LinkButton from "./LinkButton";
import "./Button.module.css"

export default function Button({to = "", children, ...props}){
    return(
        <>
            {to ? <LinkButton to={to} {...props}>{children}</LinkButton> : <button {...props}>{children}</button>}
        </>
    )
}