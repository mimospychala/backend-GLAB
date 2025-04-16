import Button from "./Button";
import { MessageCircle } from "lucide-react";

export default function CommentButton({func ,...props}){
    return (
        <Button func={func} props>
            <MessageCircle/>
        </Button>
    )
}