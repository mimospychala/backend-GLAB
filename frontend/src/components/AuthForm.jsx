import { Form } from "react-router"

import Input from "./Input"
import Button from "./Button"
import ButtonGroup from "./ButtonGroup"

export default function AuthForm({ user = {}, errors = {}, onCancel }) {
    return (
        <Form method="post" noValidate>
            <Input
                label="E-Mail:"
                type="email"
                name="email"
                placeholder="Bitte eine E-Mail Adresse eingeben"
                error={errors.email}
                defaultValue={user.email}
            />
            <Input
                label="Passwort:"
                type="password"
                name="password"
                placeholder="Bitte ein Passwort eingeben"
                error={errors.password}
                defaultValue={user.password}
            />
            <ButtonGroup>
                <Button type="submit">Speichern</Button>
                <Button type="button" onClick={onCancel}>
                    Abbrechen
                </Button>
            </ButtonGroup>
        </Form>
    )
}
