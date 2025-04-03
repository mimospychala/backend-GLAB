import LinkButton from "./LinkButton";

export default function Button({to = "", children, ...props}){
    return(
        <>
            {to ? <LinkButton to={to} {...props}>{children}</LinkButton> : <button {...props}>{children}</button>}
        </>
    )
}